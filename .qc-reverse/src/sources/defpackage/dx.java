package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dx {
    private List<lw> edgeActions;
    private Boolean enabled;

    public dx() {
        this.edgeActions = new ArrayList();
        this.enabled = Boolean.TRUE;
    }

    public final void a(lw lwVar) {
        this.edgeActions.add(lwVar);
    }

    public final lw b(int i) {
        int iJ = 0;
        for (lw lwVar : this.edgeActions) {
            iJ += lwVar.j();
            if (i <= iJ) {
                return lwVar;
            }
        }
        return null;
    }

    public final int c() {
        return this.edgeActions.size();
    }

    public final List d() {
        return this.edgeActions;
    }

    public final int e() {
        Iterator<lw> it = this.edgeActions.iterator();
        int iJ = 0;
        while (it.hasNext()) {
            iJ += it.next().j();
        }
        return iJ;
    }

    public final lw f(int i) {
        try {
            return this.edgeActions.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Boolean g() {
        return this.enabled;
    }

    public final void h(int i) {
        this.edgeActions.remove(i);
    }

    public final void i() {
        this.edgeActions.clear();
    }

    public final void j(Boolean bool) {
        this.enabled = bool;
    }

    public dx(List list) {
        this.edgeActions = list;
        this.enabled = Boolean.TRUE;
    }
}
