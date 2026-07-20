package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import defpackage.c70;
import defpackage.fb0;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements fb0 {
    @Override // defpackage.fb0
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.fb0
    public final Object b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: lr0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new f8(applicationContext, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new c70(23);
    }
}
