package androidx.media;

import android.media.AudioAttributes;
import defpackage.ue1;
import defpackage.ve1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(ue1 ue1Var) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = (AudioAttributes) ue1Var.g(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = ue1Var.f(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, ue1 ue1Var) {
        ue1Var.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.a;
        ue1Var.i(1);
        ((ve1) ue1Var).e.writeParcelable(audioAttributes, 0);
        ue1Var.j(audioAttributesImplApi21.b, 2);
    }
}
