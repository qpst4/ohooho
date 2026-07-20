package androidx.media;

import defpackage.ue1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(ue1 ue1Var) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = ue1Var.f(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = ue1Var.f(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = ue1Var.f(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = ue1Var.f(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, ue1 ue1Var) {
        ue1Var.getClass();
        ue1Var.j(audioAttributesImplBase.a, 1);
        ue1Var.j(audioAttributesImplBase.b, 2);
        ue1Var.j(audioAttributesImplBase.c, 3);
        ue1Var.j(audioAttributesImplBase.d, 4);
    }
}
