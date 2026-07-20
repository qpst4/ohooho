package defpackage;

import android.content.res.TypedArray;
import com.quickcursor.App;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jh0 {
    public final String a;
    public final String b;
    public final Integer c;
    public final Object d;

    public jh0(String str, String str2, Object obj, Integer num) {
        this.a = str;
        this.b = str2;
        this.d = obj;
        this.c = num;
    }

    public static ArrayList a(Integer num, Integer num2, Integer num3, Integer num4) {
        String[] stringArray = App.c.getResources().getStringArray(num3.intValue());
        ArrayList arrayList = new ArrayList();
        String[] stringArray2 = App.c.getResources().getStringArray(num.intValue());
        String[] stringArray3 = App.c.getResources().getStringArray(num2.intValue());
        int i = 0;
        if (num4 != null) {
            TypedArray typedArrayObtainTypedArray = App.c.getResources().obtainTypedArray(num4.intValue());
            while (i < stringArray2.length) {
                arrayList.add(new jh0(stringArray2[i], stringArray3[i], stringArray[i], Integer.valueOf(typedArrayObtainTypedArray.getResourceId(i, -1))));
                i++;
            }
        } else {
            while (i < stringArray2.length) {
                arrayList.add(new jh0(stringArray2[i], stringArray3[i], stringArray[i], null));
                i++;
            }
        }
        return arrayList;
    }

    public final String toString() {
        return "ListPickerItem{label='" + this.a + "', description='" + this.b + "', icon=" + this.c + ", value=" + this.d + '}';
    }
}
