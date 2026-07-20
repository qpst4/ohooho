package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n10 extends k {
    public final m10 a;
    public String b;
    public final StringBuilder c;

    public n10(char c, int i, int i2) {
        m10 m10Var = new m10();
        this.a = m10Var;
        this.c = new StringBuilder();
        m10Var.f = c;
        m10Var.g = i;
        m10Var.h = i2;
    }

    @Override // defpackage.k
    public final void a(CharSequence charSequence) {
        if (this.b == null) {
            this.b = charSequence.toString();
            return;
        }
        StringBuilder sb = this.c;
        sb.append(charSequence);
        sb.append('\n');
    }

    @Override // defpackage.k
    public final void c() {
        String strA = oz.a(this.b.trim());
        m10 m10Var = this.a;
        m10Var.i = strA;
        m10Var.j = this.c.toString();
    }

    @Override // defpackage.k
    public final kg d() {
        return this.a;
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        int i = ouVar.e;
        int i2 = ouVar.b;
        CharSequence charSequence = ouVar.a;
        int i3 = ouVar.g;
        m10 m10Var = this.a;
        if (i3 < 4) {
            char c = m10Var.f;
            int i4 = m10Var.g;
            int iW = i1.W(c, charSequence, i, charSequence.length()) - i;
            if (iW >= i4 && i1.X(charSequence, i + iW, charSequence.length()) == charSequence.length()) {
                return new lg(-1, -1, true);
            }
        }
        int length = charSequence.length();
        for (int i5 = m10Var.h; i5 > 0 && i2 < length && charSequence.charAt(i2) == ' '; i5--) {
            i2++;
        }
        return lg.a(i2);
    }
}
