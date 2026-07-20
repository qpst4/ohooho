package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.a;
import defpackage.fb0;
import defpackage.gg0;
import defpackage.nr;
import defpackage.o20;
import defpackage.os;
import defpackage.ra;
import defpackage.sx;
import defpackage.um;
import defpackage.ux;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements fb0 {
    @Override // defpackage.fb0
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // defpackage.fb0
    public final Object b(Context context) {
        Object objR;
        o20 o20Var = new o20(new nr(context, 1));
        o20Var.a = 1;
        if (sx.k == null) {
            synchronized (sx.j) {
                try {
                    if (sx.k == null) {
                        sx.k = new sx(o20Var);
                    }
                } finally {
                }
            }
        }
        ra raVarB = ra.B(context);
        raVarB.getClass();
        synchronized (ra.g) {
            try {
                objR = ((HashMap) raVarB.c).get(ProcessLifecycleInitializer.class);
                if (objR == null) {
                    objR = raVarB.r(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final a aVarP = ((gg0) objR).p();
        aVarP.a(new os(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // defpackage.os
            public final void a() {
                (Build.VERSION.SDK_INT >= 28 ? um.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new ux(0), 500L);
                aVarP.f(this);
            }
        });
        return Boolean.TRUE;
    }
}
