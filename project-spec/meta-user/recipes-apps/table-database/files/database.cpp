#include <cstring>
#include <string>
#include <unordered_map>
#include <vector>

#include "database.h"

struct DBContext {
    std::unordered_map<std::string, std::vector<char>> inner_;
};

struct DBContext* open_database()
{
    return new DBContext;
}

void close_database(struct DBContext* ctx)
{
    if (ctx) delete ctx;
}

int set_item(struct DBContext* ctx, char* key, unsigned int size, void* value)
{
    if (!ctx) return -1;

    std::vector<char> container(size);
    memcpy(container.data(), value, size);
    std::string map_key(key);

    auto entry = ctx->inner_.find(map_key);
    if (entry != ctx->inner_.end())
    {
        entry->second = container;
    }
    else
    {
        ctx->inner_.insert({map_key, container});
    }
    return 0;
}

int get_item(struct DBContext* ctx, char* key, unsigned int size, void* value)
{
    if (!ctx) return -1;

    std::string map_key(key);

    auto entry = ctx->inner_.find(map_key);
    if (entry != ctx->inner_.end() && (entry->second.size() == size))
    {
        memcpy(value, entry->second.data(), size);
        return 0;
    }
    return 1;
}
