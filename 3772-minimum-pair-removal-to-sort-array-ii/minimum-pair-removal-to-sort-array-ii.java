class Solution {

    static class N {
        long v;
        N p, n;
        boolean r;
        int i;

        N(long v, int i) {
            this.v = v;
            this.i = i;
        }
    }

    static class P {
        long s;
        N l, r;
        int li;

        P(N l, N r) {
            this.l = l;
            this.r = r;
            this.s = l.v + r.v;
            this.li = l.i;
        }
    }

    static boolean ok(N x) {
        return x != null && x.i != -1;
    }

    static int bad(N a, N b) {
        if (!ok(a) || b == null) return 0;
        return a.v > b.v ? 1 : 0;
    }

    public int minimumPairRemoval(int[] a) {
        if (a == null || a.length <= 1) return 0;

        N d = new N(0, -1);
        N c = d;

        for (int i = 0; i < a.length; i++) {
            N x = new N(a[i], i);
            c.n = x;
            x.p = c;
            c = x;
        }

        PriorityQueue<P> q = new PriorityQueue<>(
            (x, y) -> {
                int t = Long.compare(x.s, y.s);
                if (t != 0) return t;
                return Integer.compare(x.li, y.li);
            }
        );

        int inv = 0;
        N t = d.n;
        while (t != null && t.n != null) {
            inv += bad(t, t.n);
            q.add(new P(t, t.n));
            t = t.n;
        }

        if (inv == 0) return 0;

        int ans = 0;

        while (inv > 0) {
            P p = q.poll();
            if (p == null) break;

            N l = p.l, r = p.r;
            if (l.r || r.r) continue;
            if (l.n != r) continue;

            ans++;

            N pr = l.p;
            N nx = r.n;

            inv -= bad(pr, l);
            inv -= bad(l, r);
            inv -= bad(r, nx);

            N m = new N(l.v + r.v, l.i);

            pr.n = m;
            m.p = pr;
            m.n = nx;
            if (nx != null) nx.p = m;

            l.r = true;
            r.r = true;

            inv += bad(pr, m);
            inv += bad(m, nx);

            if (ok(pr)) q.add(new P(pr, m));
            if (nx != null) q.add(new P(m, nx));
        }

        return ans;
    }
}
