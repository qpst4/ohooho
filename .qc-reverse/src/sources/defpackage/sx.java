package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sx {
    public static final Object j = new Object();
    public static volatile sx k;
    public final ReentrantReadWriteLock a;
    public final mb b;
    public volatile int c;
    public final Handler d;
    public final ze e;
    public final rx f;
    public final c70 g;
    public final int h;
    public final fs i;

    public sx(o20 o20Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.c = 3;
        rx rxVar = (rx) o20Var.b;
        this.f = rxVar;
        int i = o20Var.a;
        this.h = i;
        this.i = (fs) o20Var.c;
        this.d = new Handler(Looper.getMainLooper());
        this.b = new mb(0);
        this.g = new c70(13);
        ze zeVar = new ze(this);
        this.e = zeVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.c = 0;
            } catch (Throwable th) {
                this.a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                rxVar.a(new ox(zeVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static sx a() {
        sx sxVar;
        synchronized (j) {
            try {
                sxVar = k;
                if (!(sxVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return sxVar;
    }

    public final int b() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.h == 1)) {
            s1.f("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
            return;
        }
        if (b() == 1) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            ze zeVar = this.e;
            sx sxVar = (sx) zeVar.a;
            try {
                sxVar.f.a(new ox(zeVar));
            } catch (Throwable th) {
                sxVar.d(th);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new hi(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092 A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {all -> 0x0085, blocks: (B:33:0x005d, B:36:0x0062, B:38:0x0066, B:40:0x0073, B:47:0x0092, B:49:0x009c, B:51:0x009f, B:53:0x00a3, B:55:0x00b3, B:56:0x00b6), top: B:97:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:33:0x005d, B:36:0x0062, B:38:0x0066, B:40:0x0073, B:47:0x0092, B:49:0x009c, B:51:0x009f, B:53:0x00a3, B:55:0x00b3, B:56:0x00b6), top: B:97:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[Catch: all -> 0x00fc, TRY_ENTER, TryCatch #2 {all -> 0x00fc, blocks: (B:60:0x00c5, B:63:0x00cd, B:66:0x00d5, B:45:0x0088), top: B:99:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r12, int r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sx.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(qx qxVar) {
        f01.k("initCallback cannot be null", qxVar);
        this.a.writeLock().lock();
        try {
            if (this.c == 1 || this.c == 2) {
                this.d.post(new hi(Arrays.asList(qxVar), this.c, (Throwable) null));
            } else {
                this.b.add(qxVar);
            }
            this.a.writeLock().unlock();
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }
}
