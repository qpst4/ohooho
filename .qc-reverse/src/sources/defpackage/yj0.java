package defpackage;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.c;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yj0 extends du0 {
    public final /* synthetic */ c a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ zj0 c;

    public yj0(zj0 zj0Var, c cVar, MaterialButton materialButton) {
        this.c = zj0Var;
        this.a = cVar;
        this.b = materialButton;
    }

    @Override // defpackage.du0
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // defpackage.du0
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int iO0;
        fi fiVar = this.a.c;
        zj0 zj0Var = this.c;
        RecyclerView recyclerView2 = zj0Var.f0;
        if (i < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
            View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false, true);
            iO0 = viewQ0 == null ? -1 : zt0.L(viewQ0);
        } else {
            iO0 = ((LinearLayoutManager) recyclerView2.getLayoutManager()).O0();
        }
        Calendar calendarA = wd1.a(fiVar.b.b);
        calendarA.add(2, iO0);
        zj0Var.b0 = new yl0(calendarA);
        Calendar calendarA2 = wd1.a(fiVar.b.b);
        calendarA2.add(2, iO0);
        calendarA2.set(5, 1);
        Calendar calendarA3 = wd1.a(calendarA2);
        calendarA3.get(2);
        calendarA3.get(1);
        calendarA3.getMaximum(7);
        calendarA3.getActualMaximum(5);
        calendarA3.getTimeInMillis();
        long timeInMillis = calendarA3.getTimeInMillis();
        Locale locale = Locale.getDefault();
        AtomicReference atomicReference = wd1.a;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        this.b.setText(instanceForSkeleton.format(new Date(timeInMillis)));
    }
}
