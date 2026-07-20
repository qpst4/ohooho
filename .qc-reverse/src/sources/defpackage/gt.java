package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class gt implements et {
    public final oh1 d;
    public int f;
    public int g;
    public oh1 a = null;
    public boolean b = false;
    public boolean c = false;
    public int e = 1;
    public int h = 1;
    public cu i = null;
    public boolean j = false;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    public gt(oh1 oh1Var) {
        this.d = oh1Var;
    }

    @Override // defpackage.et
    public final void a(et etVar) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (!((gt) obj).j) {
                return;
            }
        }
        this.c = true;
        oh1 oh1Var = this.a;
        if (oh1Var != null) {
            oh1Var.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        int size2 = arrayList.size();
        gt gtVar = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            gt gtVar2 = (gt) obj2;
            if (!(gtVar2 instanceof cu)) {
                i++;
                gtVar = gtVar2;
            }
        }
        if (gtVar != null && i == 1 && gtVar.j) {
            cu cuVar = this.i;
            if (cuVar != null) {
                if (!cuVar.j) {
                    return;
                } else {
                    this.f = this.h * cuVar.g;
                }
            }
            d(gtVar.g + this.f);
        }
        oh1 oh1Var2 = this.a;
        if (oh1Var2 != null) {
            oh1Var2.a(this);
        }
    }

    public final void b(oh1 oh1Var) {
        this.k.add(oh1Var);
        if (this.j) {
            oh1Var.a(oh1Var);
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            et etVar = (et) obj;
            etVar.a(etVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.h0);
        sb.append(":");
        switch (this.e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
