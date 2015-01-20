package com.prabin.facebookconnection;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class MainActivity extends DroidGap {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Generate HASH Key for your app
		try {
			PackageInfo info = getPackageManager().getPackageInfo(
					"com.prabin.facebookconnection",
					PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				String s = Base64.encodeToString(md.digest(), Base64.DEFAULT);
				Log.d("KeyHash:", s);

			}
		} catch (NameNotFoundException e) {

		} catch (NoSuchAlgorithmException e) {

		super.loadUrl("file:///android_asset/www/index.html");
	}
}
