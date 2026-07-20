package defpackage;

import android.media.AudioManager;
import com.quickcursor.R;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class lh1 extends de {
    public static final r71 L;
    public static final l3 M;
    public final r51 D = new r51(30, true);
    public AudioManager E;
    public Integer F;
    public Integer G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;

    static {
        r71 r71Var = new r71();
        r71Var.put("volumeMode", dn.T1);
        r71Var.put("showUI", dn.U1);
        r71Var.put("maxPerc", dn.Y1);
        r71Var.put("smoothTime", dn.a2);
        r71Var.put("hideCursor", dn.c2);
        r71Var.put("orientation", dn.d2);
        r71Var.put("verticalPosition", dn.g2);
        r71Var.put("mode", dn.f2);
        r71Var.put("showBar", Boolean.valueOf(dn.L2));
        r71Var.put("granularity", dn.X1);
        r71Var.put("accessibilityStream", dn.i2);
        L = r71Var;
        M = new l3(lh1.class, R.string.action_category_settings, R.string.action_value_volume_bar, R.string.action_title_volume_bar, R.string.action_detail_volume_bar, R.drawable.icon_action_volume_bar, 31, 8, Boolean.TRUE, new ay0(16), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    @Override // defpackage.de, defpackage.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lh1.g():void");
    }

    @Override // defpackage.de
    public final float m() {
        int streamVolume;
        Method method;
        boolean z = this.J;
        AudioManager audioManager = this.E;
        if (z) {
            Integer num = this.F;
            int i = this.K;
            Class cls = Integer.TYPE;
            try {
                try {
                    method = AudioManager.class.getMethod("getFineVolume", cls, cls);
                } catch (Exception unused) {
                    method = AudioManager.class.getMethod("semGetFineVolume", cls, cls);
                }
                streamVolume = (int) Math.ceil((((Integer) method.invoke(audioManager, num, 0)).intValue() * 1.0f) / i);
            } catch (Exception unused2) {
                streamVolume = audioManager.getStreamVolume(num.intValue());
            }
        } else {
            streamVolume = audioManager.getStreamVolume(this.F.intValue());
        }
        return (streamVolume * 1.0f) / this.G.intValue();
    }

    @Override // defpackage.de
    public final void n(final float f) {
        if (this.F != null) {
            this.D.a(new Runnable() { // from class: jh1
                @Override // java.lang.Runnable
                public final void run() {
                    Method method;
                    lh1 lh1Var = this.b;
                    boolean z = lh1Var.J;
                    AudioManager audioManager = lh1Var.E;
                    Integer num = lh1Var.F;
                    float f2 = f;
                    if (!z) {
                        audioManager.setStreamVolume(num.intValue(), Math.round(f2 * lh1Var.G.intValue()), lh1Var.H ? 1 : 0);
                        return;
                    }
                    int iRound = Math.round(f2 * lh1Var.G.intValue());
                    int i = lh1Var.K;
                    boolean z2 = lh1Var.H;
                    Class cls = Integer.TYPE;
                    try {
                        try {
                            method = AudioManager.class.getMethod("setFineVolume", cls, cls, cls, cls);
                        } catch (NoSuchMethodException unused) {
                            method = AudioManager.class.getMethod("semSetFineVolume", cls, cls, cls, cls);
                        }
                        method.invoke(audioManager, num, Integer.valueOf(i * iRound), Integer.valueOf(z2 ? 1 : 0), 0);
                    } catch (Exception unused2) {
                        audioManager.setStreamVolume(num.intValue(), iRound / 10, z2 ? 1 : 0);
                    }
                }
            });
        }
    }
}
