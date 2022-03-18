package com.objectmethod.ecommerce.service.jwt;

import java.util.Date;


import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.objectmethod.ecommerce.dto.UtenteDto;

@Service
public class JWTService {
	private static final String EMAIL = "email";
	private static final String ID = "Id";
	private static final String Admin = "amministratore";
	@Value("JWT_SECRET_KEY")
	private String secret;
	
	public String createJWTToken(UtenteDto user) {

		Date tomorrow = DateUtils.addDays(new Date(), 1);

		Algorithm alg = Algorithm.HMAC256(secret);
		String token = JWT.create()
				.withClaim(ID, user.getId())
				.withClaim(EMAIL, user.getEmail())
				.withClaim(Admin, user.getAmministratore())
				.withExpiresAt(tomorrow)
				.sign(alg);

		return token;
	}

	public boolean checkJWTToken(String jwtToken) {
		boolean valid = false;
		Algorithm alg = Algorithm.HMAC256(secret);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			Long userId = decoded.getClaim(ID).asLong();
			String email = decoded.getClaim(EMAIL).asString();
			Boolean amministratore=decoded.getClaim(Admin).asBoolean();
			valid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}

	public UtenteDto getUserByToken(String jwtToken) {
		UtenteDto user = new UtenteDto();
		Algorithm alg = Algorithm.HMAC256(secret);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);
			Long id = decoded.getClaim(ID).asLong();
			user.setId(id);
			String email = decoded.getClaim(EMAIL).asString();
			user.setEmail(email);
			Boolean amministratore=decoded.getClaim(Admin).asBoolean();
			user.setAmministratore(amministratore);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return user;
	}
}
