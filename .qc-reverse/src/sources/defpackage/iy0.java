package defpackage;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class iy0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final hy0 g;
    public String h = null;
    public Bitmap i = null;

    public iy0(Map map) {
        this.a = ((Boolean) map.getOrDefault("copyClipboard", Boolean.valueOf(dn.r2))).booleanValue();
        this.b = ((Boolean) map.getOrDefault("saveFile", Boolean.valueOf(dn.s2))).booleanValue();
        this.c = ((Boolean) map.getOrDefault("afterCrop", Boolean.valueOf(dn.t2))).booleanValue();
        this.d = ((Boolean) map.getOrDefault("afterShare", Boolean.valueOf(dn.u2))).booleanValue();
        this.e = ((Boolean) map.getOrDefault("afterSave", Boolean.valueOf(dn.v2))).booleanValue();
        this.f = ((Boolean) map.getOrDefault("afterDelete", Boolean.valueOf(dn.w2))).booleanValue();
        this.g = hy0.valueOf((String) map.getOrDefault("executeAfter", dn.x2));
    }
}
