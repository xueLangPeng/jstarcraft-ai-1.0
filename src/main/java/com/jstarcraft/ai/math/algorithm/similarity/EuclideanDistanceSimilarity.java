package com.jstarcraft.ai.math.algorithm.similarity;

import java.util.Iterator;

import org.apache.commons.math3.util.FastMath;

import com.jstarcraft.ai.math.structure.vector.MathVector;
import com.jstarcraft.ai.math.structure.vector.VectorScalar;

public class EuclideanDistanceSimilarity extends AbstractSimilarity {

	@Override
	public float getCorrelation(MathVector leftVector, MathVector rightVector, float scale) {
		// compute similarity
		float similarity = 0F;
		int leftIndex = 0, rightIndex = 0, leftSize = leftVector.getElementSize(), rightSize = rightVector.getElementSize();
		if (leftSize != 0 && rightSize != 0) {
			Iterator<VectorScalar> leftIterator = leftVector.iterator();
			Iterator<VectorScalar> rightIterator = rightVector.iterator();
			VectorScalar leftTerm = leftIterator.next();
			VectorScalar rightTerm = rightIterator.next();
			// 判断两个有序数组中是否存在相同的数字
			float distance = 0F;
			while (leftIndex < leftSize && rightIndex < rightSize) {
				if (leftTerm.getIndex() == rightTerm.getIndex()) {
					distance = leftTerm.getValue() - rightTerm.getValue();
					leftTerm = leftIterator.next();
					rightTerm = rightIterator.next();
					leftIndex++;
					rightIndex++;
				} else if (leftTerm.getIndex() > rightTerm.getIndex()) {
					distance = rightTerm.getValue();
					rightTerm = rightIterator.next();
					rightIndex++;
				} else if (leftTerm.getIndex() < rightTerm.getIndex()) {
					distance = leftTerm.getValue();
					leftTerm = leftIterator.next();
					leftIndex++;
				}
				similarity += distance * distance;
			}
		}
		return 1F / (1F + (float) FastMath.sqrt(similarity));
	}

}
