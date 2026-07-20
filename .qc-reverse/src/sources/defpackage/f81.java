package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerSettings;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f81 implements e4, zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ TrackerSettings.a c;

    public /* synthetic */ f81(TrackerSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        this.c.l0(qq0.q((String) obj));
        return true;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        TrackerSettings.a aVar = this.c;
        d4 d4Var = (d4) obj;
        StringBuilder sb = new StringBuilder("ImagePicker result code: ");
        int i = d4Var.b;
        Intent intent = d4Var.c;
        sb.append(i);
        si0.a(sb.toString());
        if (d4Var.b != -1 || intent == null || intent.getData() == null) {
            yb0.z("Error on selecting tracker image.", 0);
            return;
        }
        Uri data = intent.getData();
        si0.a("ImagePicker URI result: " + data);
        try {
            pn0.t().W(MediaStore.Images.Media.getBitmap(aVar.Z().getContentResolver(), data));
            TrackerSettings trackerSettings = aVar.i0;
            TrackerDrawable trackerDrawableN = TrackerDrawable.n(pn0.t().z());
            int i2 = TrackerSettings.D;
            trackerSettings.C.setImageDrawable(trackerDrawableN);
            trackerSettings.G();
            TrackerSettings trackerSettings2 = aVar.i0;
            Objects.requireNonNull(trackerSettings2);
            b61.b(new lk0(17, trackerSettings2), 0L);
            aVar.h0.a(new s4(15));
        } catch (Exception e) {
            si0.b("Error onImagePicked(): " + e);
        }
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        final TrackerSettings.a aVar = this.c;
        final int i2 = 1;
        switch (i) {
            case 2:
                sa0 sa0Var = new sa0(aVar);
                sa0Var.a = ta0.b;
                sa0Var.b = new String[]{"image/png", "image/jpg", "image/jpeg", "image/webp"};
                sa0Var.e = 1048576L;
                sa0Var.c = 1024;
                sa0Var.d = 1024;
                sa0Var.b(new xp(2, aVar));
                break;
            case 3:
                jl1 jl1Var = new jl1(aVar.o());
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_reset_tracker_visual_settings);
                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                final int i3 = 0;
                jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: g81
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i3;
                        TrackerSettings.a aVar2 = aVar;
                        switch (i5) {
                            case 0:
                                pn0.t().O();
                                aVar2.i0(null, null);
                                aVar2.T();
                                TrackerSettings trackerSettings = aVar2.i0;
                                Objects.requireNonNull(trackerSettings);
                                b61.b(new lk0(17, trackerSettings), 0L);
                                CursorAccessibilityService.j();
                                break;
                            default:
                                pn0.t().N();
                                aVar2.i0(null, null);
                                CursorAccessibilityService.j();
                                break;
                        }
                    }
                });
                jl1Var.h(android.R.string.no, null);
                jl1Var.n();
                break;
            default:
                jl1 jl1Var2 = new jl1(aVar.o());
                jl1Var2.m(R.string.are_you_sure);
                jl1Var2.g(R.string.confirmation_reset_tracker_behaviour_settings);
                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: g81
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i2;
                        TrackerSettings.a aVar2 = aVar;
                        switch (i5) {
                            case 0:
                                pn0.t().O();
                                aVar2.i0(null, null);
                                aVar2.T();
                                TrackerSettings trackerSettings = aVar2.i0;
                                Objects.requireNonNull(trackerSettings);
                                b61.b(new lk0(17, trackerSettings), 0L);
                                CursorAccessibilityService.j();
                                break;
                            default:
                                pn0.t().N();
                                aVar2.i0(null, null);
                                CursorAccessibilityService.j();
                                break;
                        }
                    }
                });
                jl1Var2.h(android.R.string.no, null);
                jl1Var2.n();
                break;
        }
        return true;
    }
}
