package com.jstarcraft.ai.math.algorithm.similarity;

import com.jstarcraft.ai.math.structure.DefaultScalar;
import com.jstarcraft.ai.math.structure.vector.MathVector;

/**
 * Binary Cosine相似度
 * 
 * @author Birdy
 *
 */
public class BinaryCosineSimilarity extends AbstractSimilarity {

	@Override
	public float getCorrelation(MathVector leftVector, MathVector rightVector, float scale) {
		DefaultScalar scalar = DefaultScalar.getInstance();
		float numerator = scalar.dotProduct(leftVector, rightVector).getValue();
		float denominator = 0F;
		denominator += Math.sqrt(scalar.dotProduct(leftVector, leftVector).getValue());
		denominator *= Math.sqrt(scalar.dotProduct(rightVector, rightVector).getValue());
		return numerator / denominator;
	}

}