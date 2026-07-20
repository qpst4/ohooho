package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class og extends k {
    public final mg a = new mg();

    @Override // defpackage.k
    public final kg d() {
        return this.a;
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        char cCharAt;
        int i = ouVar.e;
        CharSequence charSequence = ouVar.a;
        if (ouVar.g >= 4 || i >= charSequence.length() || charSequence.charAt(i) != '>') {
            return null;
        }
        int i2 = ouVar.c + ouVar.g;
        int i3 = i2 + 1;
        CharSequence charSequence2 = ouVar.a;
        int i4 = i + 1;
        if (i4 < charSequence2.length() && ((cCharAt = charSequence2.charAt(i4)) == '\t' || cCharAt == ' ')) {
            i3 = i2 + 2;
        }
        return new lg(-1, i3, false);
    }
}
