package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreference;
import com.quickcursor.android.preferences.AppPickerPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.quickcursor.android.preferences.WindowConfigPreference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lf0 extends d3 {
    public final /* synthetic */ int j0;
    public SwitchPreference k0;
    public Preference l0;
    public Preference m0;
    public Preference n0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lf0(int i, Map map, int i2) {
        super(i, map);
        this.j0 = i2;
    }

    @Override // defpackage.j30
    public void H(int i, int i2, Intent intent) {
        switch (this.j0) {
            case 0:
                super.H(i, i2, intent);
                WindowConfigPreference windowConfigPreference = (WindowConfigPreference) this.m0;
                windowConfigPreference.getClass();
                if (i == 10 && i2 == -1) {
                    String stringExtra = intent != null ? intent.getStringExtra("rect") : "";
                    if (stringExtra != null && stringExtra.length() > 0) {
                        windowConfigPreference.O = stringExtra;
                        if (windowConfigPreference.H()) {
                            windowConfigPreference.z(stringExtra);
                        }
                        windowConfigPreference.k();
                        break;
                    }
                }
                break;
            default:
                super.H(i, i2, intent);
                break;
        }
    }

    @Override // defpackage.d3, defpackage.gq0, defpackage.j30
    public final void J(Bundle bundle) {
        switch (this.j0) {
            case 0:
                super.J(bundle);
                this.k0 = (SwitchPreference) h0("windowed");
                this.n0 = (PreferenceCategory) h0("windowedConfigs");
                this.l0 = (AppPickerPreference) h0("packageName");
                WindowConfigPreference windowConfigPreference = (WindowConfigPreference) h0("windowConfig");
                this.m0 = windowConfigPreference;
                windowConfigPreference.P = this;
                Map map = this.i0;
                if (map != null) {
                    AppPickerPreference appPickerPreference = (AppPickerPreference) this.l0;
                    String str = (String) map.getOrDefault("packageName", "");
                    appPickerPreference.P = str;
                    if (appPickerPreference.H()) {
                        appPickerPreference.z(str);
                    }
                    WindowConfigPreference windowConfigPreference2 = (WindowConfigPreference) this.m0;
                    String str2 = (String) map.getOrDefault("windowConfig", "");
                    windowConfigPreference2.O = str2;
                    if (windowConfigPreference2.H()) {
                        windowConfigPreference2.z(str2);
                    }
                }
                SwitchPreference switchPreference = this.k0;
                switchPreference.f = new r1(13, this);
                ((PreferenceCategory) this.n0).F(switchPreference.O);
                break;
            default:
                super.J(bundle);
                this.k0 = (SwitchPreference) h0("popup");
                this.l0 = (SeekBarDialogPreference) h0("chooseSeconds");
                this.m0 = (SeekBarDialogPreference) h0("chooseMinutes");
                this.n0 = (SeekBarDialogPreference) h0("chooseHours");
                int i = this.Z.b().getInt("seconds", dn.h2.intValue());
                final int i2 = 0;
                final int i3 = 1;
                this.k0.J(i == -1);
                this.k0.f = new zp0(this) { // from class: y51
                    public final /* synthetic */ lf0 c;

                    {
                        this.c = this;
                    }

                    @Override // defpackage.zp0
                    public final boolean a(Preference preference, Object obj) {
                        int i4 = i2;
                        lf0 lf0Var = this.c;
                        switch (i4) {
                            case 0:
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                lf0Var.h0("duration").B(!zBooleanValue);
                                if (!zBooleanValue) {
                                    lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                } else {
                                    lf0Var.Z.b().edit().putInt("seconds", -1).commit();
                                }
                                break;
                            case 1:
                                lf0Var.l0(((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            case 2:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            default:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((Integer) obj).intValue());
                                break;
                        }
                        return true;
                    }
                };
                h0("duration").B(!r0.O);
                SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) this.l0;
                seekBarDialogPreference.f = new zp0(this) { // from class: y51
                    public final /* synthetic */ lf0 c;

                    {
                        this.c = this;
                    }

                    @Override // defpackage.zp0
                    public final boolean a(Preference preference, Object obj) {
                        int i4 = i3;
                        lf0 lf0Var = this.c;
                        switch (i4) {
                            case 0:
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                lf0Var.h0("duration").B(!zBooleanValue);
                                if (!zBooleanValue) {
                                    lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                } else {
                                    lf0Var.Z.b().edit().putInt("seconds", -1).commit();
                                }
                                break;
                            case 1:
                                lf0Var.l0(((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            case 2:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            default:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((Integer) obj).intValue());
                                break;
                        }
                        return true;
                    }
                };
                final int i4 = 2;
                ((SeekBarDialogPreference) this.m0).f = new zp0(this) { // from class: y51
                    public final /* synthetic */ lf0 c;

                    {
                        this.c = this;
                    }

                    @Override // defpackage.zp0
                    public final boolean a(Preference preference, Object obj) {
                        int i42 = i4;
                        lf0 lf0Var = this.c;
                        switch (i42) {
                            case 0:
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                lf0Var.h0("duration").B(!zBooleanValue);
                                if (!zBooleanValue) {
                                    lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                } else {
                                    lf0Var.Z.b().edit().putInt("seconds", -1).commit();
                                }
                                break;
                            case 1:
                                lf0Var.l0(((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            case 2:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            default:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((Integer) obj).intValue());
                                break;
                        }
                        return true;
                    }
                };
                final int i5 = 3;
                ((SeekBarDialogPreference) this.n0).f = new zp0(this) { // from class: y51
                    public final /* synthetic */ lf0 c;

                    {
                        this.c = this;
                    }

                    @Override // defpackage.zp0
                    public final boolean a(Preference preference, Object obj) {
                        int i42 = i5;
                        lf0 lf0Var = this.c;
                        switch (i42) {
                            case 0:
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                lf0Var.h0("duration").B(!zBooleanValue);
                                if (!zBooleanValue) {
                                    lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                } else {
                                    lf0Var.Z.b().edit().putInt("seconds", -1).commit();
                                }
                                break;
                            case 1:
                                lf0Var.l0(((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.m0).d0, ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            case 2:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((Integer) obj).intValue(), ((SeekBarDialogPreference) lf0Var.n0).d0);
                                break;
                            default:
                                lf0Var.l0(((SeekBarDialogPreference) lf0Var.l0).d0, ((SeekBarDialogPreference) lf0Var.m0).d0, ((Integer) obj).intValue());
                                break;
                        }
                        return true;
                    }
                };
                if (i >= 0) {
                    seekBarDialogPreference.L(i % 60);
                    ((SeekBarDialogPreference) this.m0).L((i / 60) % 60);
                    ((SeekBarDialogPreference) this.n0).L(i / 3600);
                }
                break;
        }
    }

    public void l0(int i, int i2, int i3) {
        SharedPreferences.Editor editorEdit = this.Z.b().edit();
        editorEdit.putInt("seconds", (i3 * 3600) + (i2 * 60) + i).commit();
    }
}
