package defpackage;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pd1 {
    public static final pn0 a = pn0.t();

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        xw xwVar = xw.e;
        arrayList.addAll(xwVar.d("leftEdgeBar").d());
        arrayList.addAll(xwVar.d("rightEdgeBar").d());
        arrayList.addAll(xwVar.d("topEdgeBar").d());
        arrayList.addAll(s71.e.c);
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:135:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b() {
        /*
            Method dump skipped, instruction units count: 3442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pd1.b():void");
    }

    public static void c(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, String str2) {
        if (sharedPreferences.contains(str)) {
            editor.remove(str).putInt(str2, sharedPreferences.getInt(str, 0)).apply();
        }
    }

    public static void d(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, String str2) {
        if (sharedPreferences.contains(str)) {
            editor.remove(str).putString(str2, sharedPreferences.getString(str, "")).apply();
        }
    }

    public static void e(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            lw lwVar = (lw) it.next();
            if (lwVar.a() == null) {
                lwVar.f(i3.empty);
            }
        }
    }
}
