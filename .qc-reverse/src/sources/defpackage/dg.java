package defpackage;

import android.content.ClipData;
import android.graphics.fonts.Font;
import android.view.ContentInfo;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class dg {
    public static /* synthetic */ Font.Builder g(Font font) {
        return new Font.Builder(font);
    }

    public static /* synthetic */ ContentInfo.Builder k(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* bridge */ /* synthetic */ ContentInfo m(Object obj) {
        return (ContentInfo) obj;
    }
}
