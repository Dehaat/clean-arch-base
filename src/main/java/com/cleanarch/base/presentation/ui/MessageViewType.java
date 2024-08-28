package com.cleanarch.base.presentation.ui;

import androidx.annotation.IntDef;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@IntDef({MessageViewType.TOAST, MessageViewType.DIALOG})
@Retention(AnnotationRetention.SOURCE)
public @interface MessageViewType {
    int TOAST = 0;
    int DIALOG = 1;
}
