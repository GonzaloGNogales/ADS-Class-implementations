public class HashTableMap<K,V> implements Map<K,V> {
    private int size;
    private class HashEnrty<T,U> implements Entry<T,U> {
        private T key;
        private U value;
        private HashTableMap<K,V> myMap;

        public HashEnrty (T k, U v, HashTableMap<K,V> mM) {
            this.key = k;
            this.value = v;
            this.myMap = mM;
        }

        @Override
        public T getKey () {
            return key;
        }

        public void setKey (T key) {
            this.key = key;
        }

        @Override
        public U getValue () {
            return value;
        }

        public void setValue (U value) {
            this.value = value;
        }

        public HashTableMap<K, V> getMyMap () {
            return myMap;
        }

        public void setMyMap (HashTableMap<K,V> myMap) {
            this.myMap = myMap;
        }

        @Override
        public boolean equals (Object o) {
            if (o.getClass() != this.getClass())
                return false;

            HashEnrty<T,U> ent;

            try {
                ent = (HashEnrty<T,U>) o;
            }
            catch (ClassCastException ex) {
                return false;
            }

            return (((ent.getKey()).equals(this.key)) && ((ent.getValue()).equals(this.value)));
        }
    }

}
