package defpackage;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c01 {
    public Context a;
    public String b;
    public Intent[] c;
    public ComponentName d;
    public CharSequence e;
    public CharSequence f;
    public CharSequence g;
    public IconCompat h;
    public np0[] i;
    public Set j;
    public ni0 k;
    public int l;
    public PersistableBundle m;

    public final ShortcutInfo a() {
        lx.k();
        ShortcutInfo.Builder intents = lx.c(this.a, this.b).setShortLabel(this.e).setIntents(this.c);
        IconCompat iconCompat = this.h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.g(this.a));
        }
        if (!TextUtils.isEmpty(this.f)) {
            intents.setLongLabel(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setDisabledMessage(this.g);
        }
        ComponentName componentName = this.d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set set = this.j;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.l);
        PersistableBundle persistableBundle = this.m;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            np0[] np0VarArr = this.i;
            if (np0VarArr != null && np0VarArr.length > 0) {
                int length = np0VarArr.length;
                Person[] personArr = new Person[length];
                for (int i = 0; i < length; i++) {
                    np0 np0Var = this.i[i];
                    np0Var.getClass();
                    personArr[i] = ju.p(np0Var);
                }
                intents.setPersons(personArr);
            }
            ni0 ni0Var = this.k;
            if (ni0Var != null) {
                intents.setLocusId(ni0Var.b);
            }
            intents.setLongLived(false);
        } else {
            if (this.m == null) {
                this.m = new PersistableBundle();
            }
            np0[] np0VarArr2 = this.i;
            if (np0VarArr2 != null && np0VarArr2.length > 0) {
                this.m.putInt("extraPersonCount", np0VarArr2.length);
                int i2 = 0;
                while (i2 < this.i.length) {
                    PersistableBundle persistableBundle2 = this.m;
                    StringBuilder sb = new StringBuilder("extraPerson_");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    String string = sb.toString();
                    np0 np0Var2 = this.i[i2];
                    np0Var2.getClass();
                    PersistableBundle persistableBundle3 = new PersistableBundle();
                    String str = np0Var2.a;
                    persistableBundle3.putString("name", str != null ? str.toString() : null);
                    persistableBundle3.putString("uri", np0Var2.b);
                    persistableBundle3.putString("key", np0Var2.c);
                    persistableBundle3.putBoolean("isBot", np0Var2.d);
                    persistableBundle3.putBoolean("isImportant", np0Var2.e);
                    persistableBundle2.putPersistableBundle(string, persistableBundle3);
                    i2 = i3;
                }
            }
            ni0 ni0Var2 = this.k;
            if (ni0Var2 != null) {
                this.m.putString("extraLocusId", ni0Var2.a);
            }
            this.m.putBoolean("extraLongLived", false);
            intents.setExtras(this.m);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            j0.e(intents);
        }
        return intents.build();
    }
}
