@file:Suppress("NOTHING_TO_INLINE")

package rx.dialog.android

import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import io.reactivex.Maybe
import io.reactivex.Observable

inline fun AlertDialog.Builder.confirms(positiveTitleRes: CharSequence, negativeTitleRes: CharSequence)
        : Maybe<Boolean>
        = RxDialog.confirm(this, positiveTitleRes, negativeTitleRes)

inline fun AlertDialog.Builder.confirms(@StringRes positiveTitle: Int, @StringRes negativeTitle: Int)
        : Maybe<Boolean>
        = RxDialog.confirm(this, positiveTitle, negativeTitle)
