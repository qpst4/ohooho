package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gj0 extends fp1 {
    public static int L(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map M(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return py.b;
        }
        int i = 0;
        if (size == 1) {
            bp0 bp0Var = (bp0) arrayList.get(0);
            bp0Var.getClass();
            Map mapSingletonMap = Collections.singletonMap(bp0Var.b, bp0Var.c);
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(L(arrayList.size()));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            bp0 bp0Var2 = (bp0) obj;
            linkedHashMap.put(bp0Var2.b, bp0Var2.c);
        }
        return linkedHashMap;
    }
}
