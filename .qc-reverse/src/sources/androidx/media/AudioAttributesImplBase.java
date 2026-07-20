package androidx.media;

import defpackage.qq0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = -1;

    public final boolean equals(Object obj) {
        int i;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.b == audioAttributesImplBase.b) {
            int i2 = this.c;
            int i3 = audioAttributesImplBase.c;
            int i4 = audioAttributesImplBase.d;
            if (i4 == -1) {
                int i5 = audioAttributesImplBase.a;
                int i6 = AudioAttributesCompat.b;
                if ((i3 & 1) != 1) {
                    i = 4;
                    if ((i3 & 4) != 4) {
                        switch (i5) {
                            case 2:
                                i = 0;
                                break;
                            case 3:
                                i = 8;
                                break;
                            case 4:
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i = 5;
                                break;
                            case 6:
                                i = 2;
                                break;
                            case 11:
                                i = 10;
                                break;
                            case 12:
                            default:
                                i = 3;
                                break;
                            case 13:
                                i = 1;
                                break;
                        }
                    } else {
                        i = 6;
                    }
                } else {
                    i = 7;
                }
            } else {
                i = i4;
            }
            if (i == 6) {
                i3 |= 4;
            } else if (i == 7) {
                i3 |= 1;
            }
            if (i2 == (i3 & 273) && this.a == audioAttributesImplBase.a && this.d == i4) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), Integer.valueOf(this.d)});
    }

    public final String toString() {
        String strI;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i = this.a;
        int i2 = AudioAttributesCompat.b;
        switch (i) {
            case 0:
                strI = "USAGE_UNKNOWN";
                break;
            case 1:
                strI = "USAGE_MEDIA";
                break;
            case 2:
                strI = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strI = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strI = "USAGE_ALARM";
                break;
            case 5:
                strI = "USAGE_NOTIFICATION";
                break;
            case 6:
                strI = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strI = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strI = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strI = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strI = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strI = "USAGE_GAME";
                break;
            case 15:
            default:
                strI = qq0.i("unknown usage ", i);
                break;
            case 16:
                strI = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strI);
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
}
