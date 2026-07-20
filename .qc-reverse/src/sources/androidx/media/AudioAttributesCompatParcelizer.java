package androidx.media;

import defpackage.ue1;
import defpackage.we1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(ue1 ue1Var) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        we1 we1VarH = audioAttributesCompat.a;
        if (ue1Var.e(1)) {
            we1VarH = ue1Var.h();
        }
        audioAttributesCompat.a = (AudioAttributesImpl) we1VarH;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, ue1 ue1Var) {
        ue1Var.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.a;
        ue1Var.i(1);
        ue1Var.k(audioAttributesImpl);
    }
}
