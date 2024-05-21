package edu.cnm.deepdive;

import java.util.regex.Pattern;

public enum Mode
{
    CF, FC, CK, KC, KF, FK;

    public static final Pattern PATTERN = Pattern.compile("CF|FC|CK|KC|KF|FK",Pattern.CASE_INSENSITIVE);
}
