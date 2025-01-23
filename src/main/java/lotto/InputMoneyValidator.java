package lotto;

import java.util.regex.Pattern;
import lotto.util.ErrorUtil;

public class InputMoneyValidator {
    private static final String MONEY_REGEX_PATTERN = "\\d+";
    private static final int MINIMUM_MONEY_UNIT = 1000;


    public void validate(String money) {
        validateNumber(money);
        validateTicketPrice(money);
    }

    private void validateNumber(String money) {
        if (!Pattern.matches(MONEY_REGEX_PATTERN, money)) {
            ErrorUtil.PURCHASE_MONEY_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    private void validateTicketPrice(String money) {
        if (Integer.parseInt(money)%MINIMUM_MONEY_UNIT != 0 || Integer.parseInt(money)/MINIMUM_MONEY_UNIT == 0) {
            ErrorUtil.PURCHASE_MONEY_THOUSAND_UNIT_ERROR_MESSAGE.errorException();
        }
    }

}
