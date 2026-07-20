package defpackage;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class sf1 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static go b(View view, go goVar) {
        ContentInfo contentInfoM = goVar.a.m();
        Objects.requireNonNull(contentInfoM);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoM ? goVar : new go(new sp1(contentInfoPerformReceiveContent));
    }
}
