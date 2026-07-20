package defpackage;

import android.content.pm.ShortcutInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e01 {
    public static String a(List list) {
        Iterator it = list.iterator();
        int rank = -1;
        String id = null;
        while (it.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
            if (shortcutInfo.getRank() > rank) {
                id = shortcutInfo.getId();
                rank = shortcutInfo.getRank();
            }
        }
        return id;
    }
}
