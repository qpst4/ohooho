package defpackage;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qt {
    public final Executor a;
    public final kr0 b;
    public final byte[] c;
    public final File d;
    public final String e;
    public boolean f = false;
    public rt[] g;
    public byte[] h;

    public qt(AssetManager assetManager, Executor executor, kr0 kr0Var, String str, File file) {
        byte[] bArr;
        this.a = executor;
        this.b = kr0Var;
        this.e = str;
        this.d = file;
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            switch (i) {
                case 24:
                case 25:
                    bArr = xr.k;
                    break;
                case 26:
                    bArr = xr.j;
                    break;
                case 27:
                    bArr = xr.i;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = xr.h;
                    break;
                default:
                    bArr = null;
                    break;
            }
        } else {
            bArr = xr.g;
        }
        this.c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.b.e();
            return null;
        }
    }

    public final void b(int i, Serializable serializable) {
        this.a.execute(new lm(i, 2, this, serializable));
    }
}
