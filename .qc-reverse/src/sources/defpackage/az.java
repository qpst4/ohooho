package defpackage;

import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class az implements SharedPreferences.Editor {
    public final dz a;
    public final SharedPreferences.Editor b;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public az(dz dzVar, SharedPreferences.Editor editor) {
        this.a = dzVar;
        this.b = editor;
    }

    public final void a() {
        dz dzVar = this.a;
        ArrayList arrayList = dzVar.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) obj;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(dzVar, (String) it.next());
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.b.apply();
        a();
    }

    public final void b(String str, byte[] bArr) {
        dz dzVar = this.a;
        dzVar.getClass();
        if (dz.d(str)) {
            zy.b(str);
            return;
        }
        this.c.add(str);
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strB = dzVar.b(str);
            try {
                Pair pair = new Pair(strB, new String(he.b(dzVar.c.a(bArr, strB.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
                this.b.putString((String) pair.first, (String) pair.second);
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (GeneralSecurityException e2) {
            s1.k("Could not encrypt data: ", e2.getMessage(), e2);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.d.set(true);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        boolean andSet = this.d.getAndSet(false);
        SharedPreferences.Editor editor = this.b;
        CopyOnWriteArrayList copyOnWriteArrayList = this.c;
        if (andSet) {
            dz dzVar = this.a;
            for (String str : ((HashMap) dzVar.getAll()).keySet()) {
                if (!copyOnWriteArrayList.contains(str) && !dz.d(str)) {
                    editor.remove(dzVar.b(str));
                }
            }
        }
        try {
            return editor.commit();
        } finally {
            a();
            copyOnWriteArrayList.clear();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.putInt(5);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(4);
        byteBufferAllocate.putFloat(f);
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(2);
        byteBufferAllocate.putInt(i);
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.putInt(3);
        byteBufferAllocate.putLong(j);
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        if (str2 == null) {
            str2 = "__NULL__";
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.put(bytes);
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        Set set2 = set;
        if (set == null) {
            ArraySet arraySet = new ArraySet();
            arraySet.add("__NULL__");
            set2 = arraySet;
        }
        ArrayList arrayList = new ArrayList(set2.size());
        int size = set2.size() * 4;
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
            arrayList.add(bytes);
            size += bytes.length;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
        byteBufferAllocate.putInt(1);
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            byte[] bArr = (byte[]) obj;
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        b(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        dz dzVar = this.a;
        dzVar.getClass();
        if (dz.d(str)) {
            zy.b(str);
            return null;
        }
        this.b.remove(dzVar.b(str));
        this.c.remove(str);
        return this;
    }
}
