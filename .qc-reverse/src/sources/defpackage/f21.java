package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f21 implements dt {
    public final char a;
    public int b = 0;
    public final LinkedList c = new LinkedList();

    public f21(char c) {
        this.a = c;
    }

    @Override // defpackage.dt
    public final char a() {
        return this.a;
    }

    @Override // defpackage.dt
    public final int b() {
        return this.b;
    }

    @Override // defpackage.dt
    public final int c(ct ctVar, ct ctVar2) {
        dt dtVar;
        int i = ctVar.g;
        LinkedList linkedList = this.c;
        Iterator it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                dtVar = (dt) linkedList.getFirst();
                break;
            }
            dtVar = (dt) it.next();
            if (dtVar.b() <= i) {
                break;
            }
        }
        return dtVar.c(ctVar, ctVar2);
    }

    @Override // defpackage.dt
    public final void d(u41 u41Var, u41 u41Var2, int i) {
        dt dtVar;
        LinkedList linkedList = this.c;
        Iterator it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                dtVar = (dt) linkedList.getFirst();
                break;
            } else {
                dtVar = (dt) it.next();
                if (dtVar.b() <= i) {
                    break;
                }
            }
        }
        dtVar.d(u41Var, u41Var2, i);
    }

    @Override // defpackage.dt
    public final char e() {
        return this.a;
    }

    public final void f(dt dtVar) {
        int iB = dtVar.b();
        LinkedList linkedList = this.c;
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            int iB2 = ((dt) listIterator.next()).b();
            if (iB > iB2) {
                listIterator.previous();
                listIterator.add(dtVar);
                return;
            } else if (iB == iB2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.a + "' and minimum length " + iB);
            }
        }
        linkedList.add(dtVar);
        this.b = iB;
    }
}
