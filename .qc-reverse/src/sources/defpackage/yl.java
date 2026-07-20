package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yl implements ep, Serializable {
    public final ep b;
    public final cp c;

    public yl(cp cpVar, ep epVar) {
        epVar.getClass();
        this.b = epVar;
        this.c = cpVar;
    }

    public final boolean equals(Object obj) {
        boolean zB;
        if (this == obj) {
            return true;
        }
        if (obj instanceof yl) {
            yl ylVar = (yl) obj;
            int i = 2;
            yl ylVar2 = ylVar;
            int i2 = 2;
            while (true) {
                ep epVar = ylVar2.b;
                ylVar2 = epVar instanceof yl ? (yl) epVar : null;
                if (ylVar2 == null) {
                    break;
                }
                i2++;
            }
            yl ylVar3 = this;
            while (true) {
                ep epVar2 = ylVar3.b;
                ylVar3 = epVar2 instanceof yl ? (yl) epVar2 : null;
                if (ylVar3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                while (true) {
                    cp cpVar = this.c;
                    if (!fc0.b(ylVar.i(cpVar.getKey()), cpVar)) {
                        zB = false;
                        break;
                    }
                    ep epVar3 = this.b;
                    if (!(epVar3 instanceof yl)) {
                        epVar3.getClass();
                        cp cpVar2 = (cp) epVar3;
                        zB = fc0.b(ylVar.i(cpVar2.getKey()), cpVar2);
                        break;
                    }
                    this = (yl) epVar3;
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.ep
    public final Object g(Object obj, z40 z40Var) {
        return z40Var.f(this.b.g(obj, z40Var), this.c);
    }

    @Override // defpackage.ep
    public final ep h(ep epVar) {
        return tk0.y(this, epVar);
    }

    public final int hashCode() {
        return this.c.hashCode() + this.b.hashCode();
    }

    @Override // defpackage.ep
    public final cp i(dp dpVar) {
        dpVar.getClass();
        while (true) {
            cp cpVarI = this.c.i(dpVar);
            if (cpVarI != null) {
                return cpVarI;
            }
            ep epVar = this.b;
            if (!(epVar instanceof yl)) {
                return epVar.i(dpVar);
            }
            this = (yl) epVar;
        }
    }

    @Override // defpackage.ep
    public final ep m(dp dpVar) {
        dpVar.getClass();
        cp cpVar = this.c;
        cp cpVarI = cpVar.i(dpVar);
        ep epVar = this.b;
        if (cpVarI != null) {
            return epVar;
        }
        ep epVarM = epVar.m(dpVar);
        return epVarM == epVar ? this : epVarM == my.b ? cpVar : new yl(cpVar, epVarM);
    }

    public final String toString() {
        return "[" + ((String) g("", xl.d)) + ']';
    }
}
