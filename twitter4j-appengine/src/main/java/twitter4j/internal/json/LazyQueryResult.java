/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.internal.json;

import java.util.Collection;
import java.util.Iterator;
import twitter4j.*;

import java.util.List;
import java.util.ListIterator;

/**
 * A data class representing search API response
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.4
 */
final class LazyQueryResult implements twitter4j.QueryResult {
    private static final long serialVersionUID = 1469029015622811726L;
    private twitter4j.internal.http.HttpResponse res;
    private z_T4JInternalFactory factory;
    private QueryResult target = null;
    private Query query;

    LazyQueryResult(twitter4j.internal.http.HttpResponse res, z_T4JInternalFactory factory, Query query) {
        this.res = res;
        this.factory = factory;
        this.query = query;
    }

    private QueryResult getTarget() {
        if (target == null) {
            try {
                target = factory.createQueryResult(res, query);
            } catch (TwitterException e) {
                throw new TwitterRuntimeException(e);
            }
        }
        return target;
    }

    public long getSinceId() {
        return getTarget().getSinceId();
    }


    public long getMaxId() {
        return getTarget().getMaxId();
    }


    public String getRefreshUrl() {
        return getRefreshURL();
    }

    @Override
    public String getRefreshURL() {
        return getTarget().getRefreshURL();
    }

    public int getCount() {
        return getTarget().getCount();
    }


    public double getCompletedIn() {
        return getTarget().getCompletedIn();
    }

    public String getQuery() {
        return getTarget().getQuery();
    }


    public List<Status> getTweets() {
        return getTarget().getTweets();
    }

    @Override
    public Query nextQuery() {
        return getTarget().nextQuery();
    }

    @Override
    public boolean hasNext() {
        return getTarget().hasNext();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueryResult)) return false;
        return getTarget().equals(o);
    }

    @Override
    public int hashCode() {
        return getTarget().hashCode();
    }

    @Override
    public String toString() {
        return "LazyQueryResult{" +
                "target=" + getTarget() +
                "}";
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return getTarget().getRateLimitStatus();
    }

    @Override
    public int getAccessLevel() {
        return getTarget().getAccessLevel();
    }

    @Override
    public int size() {
        return getTarget().size();
    }

    @Override
    public boolean isEmpty() {
        return getTarget().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return getTarget().contains(o);
    }

    @Override
    public Iterator<Status> iterator() {
        return getTarget().iterator();
    }

    @Override
    public Object[] toArray() {
        return getTarget().toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return getTarget().toArray(ts);
    }

    @Override
    public boolean add(Status e) {
        return getTarget().add(e);
    }

    @Override
    public boolean remove(Object o) {
        return getTarget().remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        return getTarget().containsAll(coll);
    }

    @Override
    public boolean addAll(Collection<? extends Status> coll) {
        return getTarget().addAll(coll);
    }

    @Override
    public boolean addAll(int i, Collection<? extends Status> coll) {
        return getTarget().addAll(i, coll);
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        return getTarget().removeAll(coll);
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        return getTarget().retainAll(coll);
    }

    @Override
    public void clear() {
        getTarget().clear();
    }

    @Override
    public Status get(int i) {
        return getTarget().get(i);
    }

    @Override
    public Status set(int i, Status e) {
        return getTarget().set(i, e);
    }

    @Override
    public void add(int i, Status e) {
        getTarget().add(i, e);
    }

    @Override
    public Status remove(int i) {
        return getTarget().remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return getTarget().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return getTarget().lastIndexOf(o);
    }

    @Override
    public ListIterator<Status> listIterator() {
        return getTarget().listIterator();
    }

    @Override
    public ListIterator<Status> listIterator(int i) {
        return getTarget().listIterator(i);
    }

    @Override
    public List<Status> subList(int a, int b) {
        return getTarget().subList(a, b);
    }
}
