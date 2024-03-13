package semicolonafrica.group7capstoneproject.utils;

public class AccountUtils {
    public static final int ACCOUNT_EXISTS_CODE = 409;
    public static final String ACCOUNT_EXISTS_MESSAGE = "account already exists";
    public static final int ACCOUNT_CREATION_SUCCESS_CODE = 201;
    public static final String ACCOUNT_CREATION_MESSAGE = "Account created successfully";
    public static final int ACCOUNT_NOT_EXIST_CODE = 003;
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "account does not exist";
    public static final String FOUND_CODE = "004";
    public static final String FOUND_SUCCESS = "User Account found";
    public static final int PASSWORD_NOT_MATCH_CODE = 401;
    public static final int TERMS_NOT_ACCEPTED_CODE =  403;
    public static final String TERMS_NOT_ACCEPTED_MESSAGE =  "Terms must be accepted to register";


    public static final String PASSWORD_MISMATCH_MESSAGE = "Password do not match";
    public static final String PIN_SET_UP_SUCCESSFULLY_MESSAGE = "pin set up successfully";
    public static final String BVN_NOT_VERIFIED_MESSAGE = "bnv not verified";
    public static final int BVN_NOT_VERIFIED_CODE = 401;
}
