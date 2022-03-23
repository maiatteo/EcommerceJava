package com.objectmethod.ecommerce.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objectmethod.ecommerce.service.jwt.JWTService;

@Component
public class AuthenticationFilter implements Filter{

	@Autowired
	private JWTService jwtSrv;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		// System.out.println("CIAO SONO IL FILTRO!");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String url = httpReq.getRequestURI();
		// System.out.println(url);

		if (url.contains("/api")) {
			if (url.endsWith("utenti/login")
				|| url.endsWith("utenti/registrati")
				|| url.endsWith("prodotto/all")
				|| url.endsWith("negozio/negozi")
				|| url.endsWith("negozio/{id}")
				|| "GET".equals(httpReq.getMethod())) {
				// System.out.println("RICHIESTA APPROVATA!");
				chain.doFilter(request, response);
			} else {
				String token = httpReq.getHeader("hai accesso");
				if (token != null) {
					if (jwtSrv.checkJWTToken(token)) {
						// System.out.println("TOKEN VALIDO RICHIESTA APPROVATA!");
						chain.doFilter(request, response);
					} else {
						// System.out.println("TOKEN NON VALIDO RICHIESTA BLOCCATA!");
						httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					}
				} else {
					// System.out.println("TOKEN NON PRESENTE RICHIESTA BLOCCATA!");
					httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
			}
		} else {
			chain.doFilter(request, response);
		}
	}
}

