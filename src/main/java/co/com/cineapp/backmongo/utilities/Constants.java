package co.com.cineapp.backmongo.utilities;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

	public static final String REGEX_NUMERIC = "^[0-9]*$";
	public static final String REGEX_DECIMAL = "^(\\d+(\\.\\d{1,2})?)?$";
	public static final String REGEX_ALPHANUMERIC = "^[\\p{L}\\p{N} ]*$";
	public static final String REGEX_ALPHANUMERIC_W_SPECIAL_CHARS = "^[\\p{L}\\p{N} .,'\"!@#$%&*()_+=\\-\\[\\]{}:;?/\\\\|]*$";

	public static final String CINE_APP_BACK_MONGO_QUEUE = "cineAppBackMongoQueue";

	public static final String CINE_APP_BACK_MONGO_INPUT_CHANNEL = "cineAppBackMongoInputChannel";
	public static final String CINE_APP_BACK_MONGO_OUTPUT_CHANNEL = "cineAppBackMongoOutputChannel";

}