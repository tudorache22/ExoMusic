package it.exolab.generatoreOtp;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

public class GeneraOtp {

	public String generator() throws NoSuchAlgorithmException, InvalidKeyException {
		final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();

		final Key key;
		{
			final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());

			final int macLengthInBytes = Mac.getInstance(totp.getAlgorithm()).getMacLength();
			keyGenerator.init(macLengthInBytes * 8);

			key = keyGenerator.generateKey();
		}

		final Instant now = Instant.now();

		return (totp.generateOneTimePasswordString(key, now));
	}

}
