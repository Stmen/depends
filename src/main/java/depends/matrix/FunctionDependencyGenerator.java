/*
MIT License

Copyright (c) 2018-2019 Gang ZHANG

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package depends.matrix;

import depends.entity.Entity;
import depends.entity.FunctionEntity;
import depends.entity.repo.EntityRepo;
import depends.relations.Relation;

public class FunctionDependencyGenerator extends DependencyGenerator {
	public DependencyMatrix build(EntityRepo entityRepo) {
		DependencyMatrix dependencyMatrix = new DependencyMatrix();
		for (Entity entity : entityRepo.getEntities()) {
			if (entity instanceof FunctionEntity) {
				dependencyMatrix.addNode(stripper.stripFilename(entity.getDisplayName()),entity.getId());
			}
			int entityFrom = getFunctionEntityIdNoException(entity);
			if (entityFrom == -1)
				continue;
			for (Relation relation : entity.getRelations()) {
				if (relation.getEntity().getId() >= 0) {
					int entityTo = getFunctionEntityIdNoException(relation.getEntity());
					if (entityTo == -1)
						continue;
					dependencyMatrix.addDependency(relation.getType(), entityFrom, entityTo, 1,buildDescription(entity,
							relation.getEntity()));
				}
			}
		}
		return dependencyMatrix;
	}


	private int getFunctionEntityIdNoException(Entity entity) {
		Entity ancestor = entity.getAncestorOfType(FunctionEntity.class);
		if (ancestor == null)
			return -1;
		return ancestor.getId();
	}

}
