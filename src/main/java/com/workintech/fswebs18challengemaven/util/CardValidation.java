package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    public static void checkSaveValue(Card card) {
        if (card.getType() == Type.JOKER) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("JOKER kartının hem value hem de color değeri null olmalıdır!", HttpStatus.BAD_REQUEST);
            }
        } else if (card.getValue() != null && card.getType() != null) {
            throw new CardException("Bir kartın hem type hem de value değeri olamaz!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkUpdateValue(Card card) {
        if (card.getId() == null) {
            throw new CardException("Güncelleme işlemi için ID gereklidir!", HttpStatus.BAD_REQUEST);
        }
        checkSaveValue(card);
    }

}
