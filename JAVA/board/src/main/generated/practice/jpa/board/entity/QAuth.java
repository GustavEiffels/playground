package practice.jpa.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuth is a Querydsl query type for Auth
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuth extends EntityPathBase<Auth> {

    private static final long serialVersionUID = 66376229L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuth auth = new QAuth("auth");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath loginId = createString("loginId");

    public final QMember member;

    public final StringPath password = createString("password");

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final ListPath<Post, QPost> posts = this.<Post, QPost>createList("posts", Post.class, QPost.class, PathInits.DIRECT2);

    public final QRefreshToken refreshToken;

    public final ListPath<RoleAndAuth, QRoleAndAuth> roleAndAuths = this.<RoleAndAuth, QRoleAndAuth>createList("roleAndAuths", RoleAndAuth.class, QRoleAndAuth.class, PathInits.DIRECT2);

    public QAuth(String variable) {
        this(Auth.class, forVariable(variable), INITS);
    }

    public QAuth(Path<? extends Auth> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuth(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuth(PathMetadata metadata, PathInits inits) {
        this(Auth.class, metadata, inits);
    }

    public QAuth(Class<? extends Auth> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
        this.refreshToken = inits.isInitialized("refreshToken") ? new QRefreshToken(forProperty("refreshToken"), inits.get("refreshToken")) : null;
    }

}

