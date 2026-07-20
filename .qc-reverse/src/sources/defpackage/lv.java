package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import com.quickcursor.App;
import com.quickcursor.android.activities.ShortcutActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lv {
    public static final i70 a = new i70();

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        uv0 uv0VarA = xv0.d.a();
        if (!uv0VarA.o()) {
            int i = uv0VarA.p() ? -1 : 0;
            for (f91 f91Var : uv0VarA.p() ? Collections.singletonList(uv0VarA.e().d()) : uv0VarA.k()) {
                n3 n3Var = n3.shortcutTriggerCursor;
                wa waVar = new wa();
                waVar.put("trigger", String.valueOf(i));
                waVar.put("timeout", l01.auto.toString());
                i iVar = new i(n3Var, waVar);
                String strJ = ShortcutActivity.J(iVar);
                String strI = ShortcutActivity.I(iVar, strJ);
                Intent intent = new Intent(App.c, (Class<?>) ShortcutActivity.class);
                intent.setAction("android.intent.action.VIEW");
                intent.putExtra("a", a.i(iVar));
                Context context = App.c;
                c01 c01Var = new c01();
                c01Var.a = context;
                c01Var.b = strI;
                c01Var.e = strJ;
                c01Var.f = strJ;
                Bitmap bitmapF = ShortcutActivity.F(iVar);
                PorterDuff.Mode mode = IconCompat.k;
                bitmapF.getClass();
                IconCompat iconCompat = new IconCompat(5);
                iconCompat.b = bitmapF;
                c01Var.h = iconCompat;
                c01Var.c = new Intent[]{intent};
                if (TextUtils.isEmpty(c01Var.e)) {
                    zy.n("Shortcut must have a non-empty label");
                    return null;
                }
                Intent[] intentArr = c01Var.c;
                if (intentArr == null || intentArr.length == 0) {
                    zy.n("Shortcut must have an intent");
                    return null;
                }
                arrayList.add(c01Var);
                i++;
            }
        }
        return arrayList;
    }

    public static void b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return;
        }
        try {
            ArrayList arrayListV = f01.v(App.c);
            ArrayList arrayListA = a();
            List list = (List) arrayListV.stream().map(new u2(1)).collect(Collectors.toList());
            int i2 = 0;
            List list2 = (List) list.stream().filter(new kv(0, (List) arrayListA.stream().map(new u2(1)).collect(Collectors.toList()))).collect(Collectors.toList());
            if (list2.size() > 0) {
                Context context = App.c;
                if (i >= 25) {
                    b01.c(context.getSystemService(b01.d())).removeDynamicShortcuts(list2);
                }
                f01.z(context).getClass();
                Iterator it = ((ArrayList) f01.y(context)).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            int size = arrayListA.size();
            while (i2 < size) {
                Object obj = arrayListA.get(i2);
                i2++;
                c01 c01Var = (c01) obj;
                if (!list.contains(c01Var.b)) {
                    f01.L(App.c, c01Var);
                }
            }
        } catch (Throwable th) {
            si0.a("DynamicShortcutsService.refreshShortcuts(): " + th);
        }
    }
}
