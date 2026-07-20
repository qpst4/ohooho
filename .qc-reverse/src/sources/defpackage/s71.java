package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.quickcursor.App;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s71 {
    public static final s71 e = new s71();
    public final i70 a = new i70();
    public final SharedPreferences b;
    public List c;
    public j71 d;

    public s71() {
        Context context = App.c;
        this.b = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        b();
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        n3 n3Var = n3.gestureSwipe;
        wa waVar = o60.k;
        wi0 wi0Var = new wi0(waVar);
        wi0Var.put("swipeDirection", m60.BOTTOM);
        arrayList.add(new j71(n3Var, wi0Var));
        List list = this.c;
        wi0 wi0Var2 = new wi0(waVar);
        wi0Var2.put("swipeDirection", m60.LEFT);
        list.add(new j71(n3Var, wi0Var2));
        List list2 = this.c;
        wi0 wi0Var3 = new wi0(waVar);
        wi0Var3.put("swipeDirection", m60.TOP);
        list2.add(new j71(n3Var, wi0Var3));
        List list3 = this.c;
        r71 r71Var = new r71(waVar);
        r71Var.put("swipeDirection", m60.RIGHT);
        list3.add(new j71(n3Var, r71Var));
        this.d = new j71(n3.nothing, null);
        c();
    }

    public final void b() {
        List list;
        i70 i70Var = this.a;
        SharedPreferences sharedPreferences = this.b;
        j71 j71Var = null;
        try {
            list = (List) i70Var.f(sharedPreferences.getString("trackerActions", null), j71.LIST_HASH_TYPE);
        } catch (Exception unused) {
            list = null;
        }
        this.c = list;
        String string = sharedPreferences.getString("trackerActionsCenterAction", null);
        try {
            i70Var.getClass();
            j71Var = (j71) i70Var.e(string, new mc1(j71.class));
        } catch (Exception unused2) {
        }
        this.d = j71Var;
        if (this.c == null || j71Var == null) {
            a();
        }
    }

    public final void c() {
        SharedPreferences.Editor editorEdit = this.b.edit();
        List list = this.c;
        Type type = j71.LIST_HASH_TYPE;
        i70 i70Var = this.a;
        editorEdit.putString("trackerActions", i70Var.j(list, type)).putString("trackerActionsCenterAction", i70Var.j(this.d, j71.class)).apply();
    }
}
