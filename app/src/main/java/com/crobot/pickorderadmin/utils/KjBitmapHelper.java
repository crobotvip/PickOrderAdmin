package com.crobot.pickorderadmin.utils;

import org.kymjs.kjframe.KJBitmap;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class KjBitmapHelper {
    private static KJBitmap kjBitmap = null;

    private KjBitmapHelper() {

    }

    public static KJBitmap getInstance() {
        if (kjBitmap == null)
            kjBitmap = new KJBitmap();
        return kjBitmap;
    }
}
