package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class jl extends pl {
    public static List M0(int i, List list) {
        if (i < 0) {
            s1.m("Requested element count ", i, " is less than zero.");
            return null;
        }
        oy oyVar = oy.b;
        if (i != 0) {
            if (i < list.size()) {
                if (i == 1) {
                    if (list.isEmpty()) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    return lc1.V(list.get(0));
                }
                ArrayList arrayList = new ArrayList(i);
                Iterator it = list.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    arrayList.add(it.next());
                    i2++;
                    if (i2 == i) {
                        break;
                    }
                }
                int size = arrayList.size();
                return size != 0 ? size != 1 ? arrayList : lc1.V(arrayList.get(0)) : oyVar;
            }
            int size2 = list.size();
            if (size2 != 0) {
                return size2 != 1 ? new ArrayList(list) : lc1.V(list.get(0));
            }
        }
        return oyVar;
    }
}
