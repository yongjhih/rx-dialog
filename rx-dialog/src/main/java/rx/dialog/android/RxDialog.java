/*
 * Copyright (C) 2017, Andrew Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.dialog.android;

import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;

public class RxDialog {

    // TODO
    //@NonNull
    //@CheckReturnValue
    //public static Maybe<Integer> select(
    //        @NonNull AlertDialog.Builder builder) {
    //    //return builder;
    //}

    @NonNull
    @CheckReturnValue
    public static Maybe<Boolean> confirm(
            @NonNull final AlertDialog.Builder builder,
            @StringRes final int positiveTitleRes,
            @StringRes final int negativeTitleRes
    ) {
        return Maybe.create(new MaybeOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull final MaybeEmitter<Boolean> emitter) throws Exception {
                builder.setPositiveButton(positiveTitleRes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!emitter.isDisposed()) {
                                    emitter.onSuccess(true);
                                }
                            }
                        })
                        .setNegativeButton(negativeTitleRes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!emitter.isDisposed()) {
                                    emitter.onSuccess(false);
                                }
                            }
                        })
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                if (!emitter.isDisposed()) {
                                    emitter.onComplete();
                                }
                            }
                        }).show();
            }
        });
    }

    @NonNull
    @CheckReturnValue
    public static Maybe<Boolean> confirm(
            @NonNull final AlertDialog.Builder builder,
            @NonNull final CharSequence positiveTitle,
            @NonNull final CharSequence negativeTitle
    ) {
        return Maybe.create(new MaybeOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull final MaybeEmitter<Boolean> emitter) throws Exception {
                builder.setPositiveButton(positiveTitle, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!emitter.isDisposed()) {
                                    emitter.onSuccess(true);
                                }
                            }
                        })
                        .setNegativeButton(negativeTitle, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!emitter.isDisposed()) {
                                    emitter.onSuccess(false);
                                }
                            }
                        })
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                if (!emitter.isDisposed()) {
                                    emitter.onComplete();
                                }
                            }
                        }).show();
            }
        });
    }
}
