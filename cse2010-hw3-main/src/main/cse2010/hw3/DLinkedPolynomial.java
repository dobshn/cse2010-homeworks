package cse2010.hw3;

/*
 * © 2024 CSE2010 HW #3
 *
 * You can freely modify this class except the signatures of the public methods!!
 */

import java.util.TreeMap;

public class DLinkedPolynomial implements Polynomial {

    private DLinkedList<Term> list = null;

    public DLinkedPolynomial() {
        list = new DLinkedList<>();
    }

    public int getDegree() {

        if (this.list.isEmpty()) return 0;
        return list.getFirstNode().getInfo().expo; // you may delete this line
    }

    @Override
    public double getCoefficient(final int expo) {
        Node<Term> term = list.find(new Term(0.0, expo), Term::compareExponents);

        return term.getInfo().coeff; // you may delete this line
    }

    // this의 값들을 복사해서 result로 내놓는 함수
    private Polynomial copy() {

        Polynomial result = new DLinkedPolynomial();

        Node<Term> cursor = this.list.getFirstNode();

        while (cursor != null && cursor != this.list.getLastNode().getNext()) {
            result.addTerm(cursor.getInfo().coeff, cursor.getInfo().expo);
            cursor = cursor.getNext();
        }

        return result;
    }

    private Term addTerms(Term x, Term y) {
        return new Term(x.coeff + y.coeff, x.expo);
    }

    // this가 empty일 때 add를 하는 경우
    @Override
    public Polynomial add(final Polynomial p) {

        Polynomial result = this.copy();

        DLinkedPolynomial P = ((DLinkedPolynomial)p);

        Node<Term> cursor = P.list.getFirstNode();

        while (cursor != null && cursor != P.list.getLastNode().getNext()) {
            result.addTerm(cursor.getInfo().coeff, cursor.getInfo().expo);
            cursor = cursor.getNext();
        }

        return result; // you may delete this line
    }

    private Term multTerms(Term x, Term y) {
        return new Term(x.coeff * y.coeff, x.expo + y.expo);
    }

    @Override
    public Polynomial mult(final Polynomial p) {
        DLinkedPolynomial P = ((DLinkedPolynomial) p);
        Node<Term> cursor = P.list.getFirstNode();
        Polynomial result = new DLinkedPolynomial();

        while (cursor != null && cursor != P.list.getLastNode().getNext()) {

            // cursor와 this를 multOneTerm한 결과를 result에 더한다.
            result = result.add(multOneTerm(cursor.getInfo(), this)); // 이게 문제였음 !

            cursor = cursor.getNext();
        }

        /*
            Complete the code here
         */

        return result; // you may delete this line
    }

    // term과 polynomial을 입력 받아 곱한 값을 return
    private Polynomial multOneTerm (Term term, Polynomial p) {
        DLinkedPolynomial P = ((DLinkedPolynomial) p);
        Polynomial result = new DLinkedPolynomial();

        Node<Term> cursor = P.list.getFirstNode();

        Term resultTerm;

        while (cursor != null && cursor != P.list.getLastNode().getNext()) {
            resultTerm = multTerms(cursor.getInfo(), term);
            result.addTerm(resultTerm.coeff, resultTerm.expo);
            cursor = cursor.getNext();
        }

        return result;
    }


    @Override
    public void addTerm(final double coeff, final int expo) {

        Node<Term> adder = new Node<Term>(new Term(coeff, expo));

        // list가 비어있는지 확인
        if (list.isEmpty()) {
            // 그냥 추가
            list.addFirst(adder);
        } else {
            Node<Term> cursor = list.getFirstNode();

            while (cursor != list.getLastNode()) {
                if (expo < cursor.getInfo().expo) {
                    cursor = cursor.getNext();
                } else if (expo == cursor.getInfo().expo) {
                    cursor.getInfo().coeff += coeff;
                    return;
                } else {
                    list.addBefore(cursor, adder);
                    return;
                }
            }

            if (expo == cursor.getInfo().expo) {
                cursor.getInfo().coeff += coeff;
            } else if(expo < cursor.getInfo().expo) {
                list.addAfter(cursor, adder);
            } else {
                list.addBefore(cursor, adder);
            }
        }

        /*
            Complete the code here
         */

    }

    @Override
    public void removeTerm(final int expo) {
        Node<Term> node = list.find(new Term(0, expo), Term::compareExponents);

        if (node == null) {
            throw new NoSuchTermExistsException();
        } else {
            list.remove(node);
        }

    }

    @Override
    public int termCount() {
        return list.size();
    }

    @Override
    public double evaluate(final double val) {
        double sum = 0;
        Node<Term> cursor = this.list.getFirstNode();

        while (cursor != null && cursor != this.list.getLastNode().getNext()) {
            sum += Math.pow(val, cursor.getInfo().expo) * cursor.getInfo().coeff;
            cursor = cursor.getNext();
        }

        return sum; // you may delete this line
    }

    @Override
    public String toString() {
        if (list.isEmpty())
            return "Empty Polynomial";
        else {
            String[] terms = new String[termCount()];
            int i = 0;
            Node<Term> current = list.getFirstNode();
            do {
                if (current.getInfo().expo == 0) {
                    terms[i++] = String.valueOf(current.getInfo().coeff);
                } else if (current.getInfo().expo == 1) {
                    terms[i++] = current.getInfo().coeff + "x";
                } else {
                    terms[i++] = current.getInfo().coeff + "x^" + current.getInfo().expo;
                }
                current = list.getNextNode(current);
            } while (current != null);
            return String.join("+", terms);
        }
    }

}
