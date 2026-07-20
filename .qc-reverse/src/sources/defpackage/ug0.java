package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ug0 {
    public StringBuilder d;
    public String e;
    public String f;
    public char g;
    public StringBuilder h;
    public int a = 1;
    public final StringBuilder b = new StringBuilder();
    public final ArrayList c = new ArrayList();
    public boolean i = false;

    public final void a() {
        if (this.i) {
            String strA = oz.a(this.f);
            StringBuilder sb = this.h;
            String strA2 = sb != null ? oz.a(sb.toString()) : null;
            String str = this.e;
            tg0 tg0Var = new tg0();
            tg0Var.f = str;
            tg0Var.g = strA;
            tg0Var.h = strA2;
            this.c.add(tg0Var);
            this.d = null;
            this.i = false;
            this.e = null;
            this.f = null;
            this.h = null;
        }
    }
}
