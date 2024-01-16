package practice.jpa.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoleAndAuth is a Querydsl query type for RoleAndAuth
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleAndAuth extends EntityPathBase<RoleAndAuth> {

    private static final long serialVersionUID = -1688124500L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoleAndAuth roleAndAuth = new QRoleAndAuth("roleAndAuth");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QAuth auth;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final QRole role;

    public QRoleAndAuth(String variable) {
        this(RoleAndAuth.class, forVariable(variable), INITS);
    }

    public QRoleAndAuth(Path<? extends RoleAndAuth> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoleAndAuth(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoleAndAuth(PathMetadata metadata, PathInits inits) {
        this(RoleAndAuth.class, metadata, inits);
    }

    public QRoleAndAuth(Class<? extends RoleAndAuth> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.auth = inits.isInitialized("auth") ? new QAuth(forProperty("auth"), inits.get("auth")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

